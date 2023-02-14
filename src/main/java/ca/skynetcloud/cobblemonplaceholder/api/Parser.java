package ca.skynetcloud.cobblemonplaceholder.api;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.storage.party.PlayerPartyStore;
import com.cobblemon.mod.common.pokemon.Pokemon;
import me.clip.placeholderapi.expansion.cloud.CloudExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public interface  Parser {

    String getID();

    void register();

    Object parse(final Player p0, final String[]p1);

    default Pokemon getParty(final Player player) {
        return this.getParty(player.getPlayer());
    }

    @Nullable
    default Pokemon getPokemon(final Player player, final int slot) {
        return this.getPokemon(player.getPlayer(), slot);
    }

}
