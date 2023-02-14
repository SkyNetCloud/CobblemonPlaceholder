package ca.skynetcloud.cobblemonplaceholder.impl.party.evs;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class EvPercentageParser extends PartyParser
{

    public EvPercentageParser() {
        super(0);

    }

    protected EvPercentageParser(final int slot, final boolean isEv) {
        super(slot);
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_ev" + "_percentage";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new EvPercentageParser(i, false));
            CobblemonExpansion.registerParser(new EvPercentageParser(i, true));
        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
            return String.format("%.2f", pokemon.getEvs().getDefaultValue() * 100.0D / 510.0D);

    }
}
