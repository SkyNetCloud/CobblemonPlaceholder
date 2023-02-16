package ca.skynetcloud.cobblemonplaceholder.impl.party.evs;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class PartyEvDefenceParser extends PartyParser {

    private final Stats stat;

    public PartyEvDefenceParser() {
        super(0);
        this.stat = Stats.DEFENCE;

    }

    protected PartyEvDefenceParser(final int slot, final Stats stat) {
        super(slot);
        this.stat = stat;
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_ev_def";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
                CobblemonExpansion.registerParser(new PartyEvDefenceParser(i, stat));

        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return pokemon.getEvs().getOrDefault(Stats.DEFENCE);
    }
}
