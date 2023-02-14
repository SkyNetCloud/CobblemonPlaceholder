package ca.skynetcloud.cobblemonplaceholder.api;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.storage.NoPokemonStoreException;
import com.cobblemon.mod.common.api.storage.party.PlayerPartyStore;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public interface  Parser {

    String getID();

    void register();

    Object parse(final Player p0, final String[]p1);

    default PlayerPartyStore getParty(final Player player) {
        return Cobblemon.INSTANCE.getStorage().getParty((ServerPlayer) player);
    }

    @Nullable
    default Pokemon getPartyPokemon(final Player player, final int slot) {
        try {
            return Cobblemon.INSTANCE.getStorage().getParty(player.getUniqueId()).get(slot - 1);
        } catch (NoPokemonStoreException e) {
            throw new RuntimeException(e);
        }
    }

}
