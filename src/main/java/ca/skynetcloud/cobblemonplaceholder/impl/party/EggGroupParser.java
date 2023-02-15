package ca.skynetcloud.cobblemonplaceholder.impl.party;

import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class EggGroupParser extends PartyParser {
    public EggGroupParser() {
        super(0);
    }

    protected EggGroupParser(final int slot) {
        super(slot);
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_egg_group";
    }


    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new EggGroupParser(i));
        }
    }

    @Override
    public Object parse(Player player, Pokemon pokemon, String[] args) {
        return pokemon.getSpecies().getEggGroups().toString().trim();
    }
}
