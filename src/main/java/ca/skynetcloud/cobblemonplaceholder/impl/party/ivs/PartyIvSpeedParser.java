package ca.skynetcloud.cobblemonplaceholder.impl.party.ivs;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class PartyIvSpeedParser extends PartyParser {

    private final Stats stat;

    public PartyIvSpeedParser() {
        super(0);
        this.stat = Stats.valueOf(null);

    }

    protected PartyIvSpeedParser(final int slot, final Stats stat) {
        super(slot);
        this.stat = stat;
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_iv_spe";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
                CobblemonExpansion.registerParser(new PartyIvSpeedParser(i, stat));
        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return pokemon.getIvs().getOrDefault(Stats.SPEED);
    }
}
