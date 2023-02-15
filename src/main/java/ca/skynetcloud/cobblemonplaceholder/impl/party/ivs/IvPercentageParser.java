package ca.skynetcloud.cobblemonplaceholder.impl.party.ivs;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class IvPercentageParser extends PartyParser
{

    public IvPercentageParser() {
        super(0);

    }

    protected IvPercentageParser(final int slot) {
        super(slot);
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_iv" + "_percentage";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new IvPercentageParser(i));
            CobblemonExpansion.registerParser(new IvPercentageParser(i));
        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {

            return String.format("%.2f", pokemon.getIvs().getOrDefault(Stats.HP) + pokemon.getIvs().getOrDefault(Stats.ATTACK) + pokemon.getIvs().getOrDefault(Stats.DEFENCE) + pokemon.getIvs().getOrDefault(Stats.SPECIAL_ATTACK) + pokemon.getIvs().getOrDefault(Stats.SPECIAL_DEFENCE) + pokemon.getIvs().getOrDefault(Stats.SPEED)  * 100.0D / 510.0D);

    }
}
