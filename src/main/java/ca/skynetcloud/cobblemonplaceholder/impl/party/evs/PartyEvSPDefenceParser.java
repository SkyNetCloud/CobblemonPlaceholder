package ca.skynetcloud.cobblemonplaceholder.impl.party.evs;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class PartyEvSPDefenceParser extends PartyParser {

    private final Stats stat;

    public PartyEvSPDefenceParser() {
        super(0);
        this.stat = Stats.valueOf(null);

    }

    protected PartyEvSPDefenceParser(final int slot, final Stats stat) {
        super(slot);
        this.stat = stat;
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_ev_spd";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
                CobblemonExpansion.registerParser(new PartyEvSPDefenceParser(i, stat));
        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return pokemon.getEvs().getOrDefault(Stats.SPECIAL_DEFENCE);
    }
}
