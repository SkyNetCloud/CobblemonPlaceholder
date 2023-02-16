package ca.skynetcloud.cobblemonplaceholder.impl.party;

import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class LevelParser extends PartyParser
{
    public LevelParser() {
        super(0);
    }

    protected LevelParser(final int slot) {
        super(slot);
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_level";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new LevelParser(i));
        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return pokemon.getLevel();
    }
}
