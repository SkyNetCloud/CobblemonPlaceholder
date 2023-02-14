package ca.skynetcloud.cobblemonplaceholder.impl.party.ivs;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PartyIvSPAttackParser extends PartyParser {

    private final Stats stat;

    public PartyIvSPAttackParser() {
        super(0);
        this.stat = Stats.SPECIAL_ATTACK;

    }

    protected PartyIvSPAttackParser(final int slot, final Stats stat) {
        super(slot);
        this.stat = stat;
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_iv_spa";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
                CobblemonExpansion.registerParser(new PartyIvSPAttackParser(i, stat));
        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        Bukkit.getLogger().info(String.valueOf(pokemon.getIvs().getOrDefault(Stats.SPEED)));
        return pokemon.getIvs().getOrDefault(Stats.SPECIAL_ATTACK);
    }
}
