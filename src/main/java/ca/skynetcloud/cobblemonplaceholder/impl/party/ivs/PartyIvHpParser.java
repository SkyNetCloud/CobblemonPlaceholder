package ca.skynetcloud.cobblemonplaceholder.impl.party.ivs;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class PartyIvHpParser extends PartyParser {

    private final Stats stat;

    public PartyIvHpParser() {
        super(0);
        this.stat = Stats.HP;

    }

    protected PartyIvHpParser(final int slot, final Stats stat) {
        super(slot);
        this.stat = stat;
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_iv_hp";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new PartyIvHpParser(i, stat));
        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return pokemon.getIvs().getOrDefault(Stats.HP);
    }
}

