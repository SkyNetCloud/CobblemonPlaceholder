package ca.skynetcloud.cobblemonplaceholder.impl.party.evs;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class EvPercentageParser extends PartyParser
{

    public EvPercentageParser() {
        super(0);

    }

    protected EvPercentageParser(final int slot) {
        super(slot);
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_ev" + "_percentage";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new EvPercentageParser(i));
        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return String.format("%.2f", pokemon.getEvs().getOrDefault(Stats.HP) + pokemon.getEvs().getOrDefault(Stats.ATTACK) + pokemon.getEvs().getOrDefault(Stats.DEFENCE) + pokemon.getEvs().getOrDefault(Stats.SPECIAL_ATTACK) + pokemon.getEvs().getOrDefault(Stats.SPECIAL_DEFENCE) + pokemon.getEvs().getOrDefault(Stats.SPEED)  * 100.0D / 510.0D);

    }
}
