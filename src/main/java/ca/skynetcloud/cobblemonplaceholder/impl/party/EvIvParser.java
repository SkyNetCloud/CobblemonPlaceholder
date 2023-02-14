// 
// Decompiled by Procyon v0.5.36
// 

package ca.skynetcloud.cobblemonplaceholder.impl.party;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class EvIvParser extends PartyParser
{
    private final boolean isEv;
    private final String suffix;
    private final Stats stat;
    
    public EvIvParser() {
        super(0);
        this.isEv = false;
        this.suffix = "";
        this.stat = null;
    }
    
    protected EvIvParser(final int slot, final boolean isEv, final String suffix, final Stats stat) {
        super(slot);
        this.isEv = isEv;
        this.suffix = suffix;
        this.stat = stat;
    }
    
    @Override
    public String getID() {
        return "party_" + this.slot + "_" + (this.isEv ? "ev" : "iv") + "_" + this.suffix;
    }
    
    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            for (final Stats stat : Stats.values()) {
                CobblemonExpansion.registerParser(new EvIvParser(i, true, stat.name().toLowerCase(), stat));
                CobblemonExpansion.registerParser(new EvIvParser(i, true, this.resolveSuffix(stat), stat));
                CobblemonExpansion.registerParser(new EvIvParser(i, false, stat.name().toLowerCase(), stat));
                CobblemonExpansion.registerParser(new EvIvParser(i, false, this.resolveSuffix(stat), stat));
            }
        }
    }
    
    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        if (this.isEv) {
            return pokemon.getEvs().get(this.stat);
        }
        return pokemon.getIvs().get(this.stat);
    }
    
    private String resolveSuffix(final Stats stat) {
        switch (stat) {
            case HP: {
                return "hp";
            }
            case ATTACK: {
                return "atk";
            }
            case DEFENCE: {
                return "def";
            }
            case SPECIAL_ATTACK: {
                return "spa";
            }
            case SPECIAL_DEFENCE:S: {
                return "spd";
            }
            case SPEED: {
                return "spe";
            }
            default: {
                return "";
            }
        }
    }
}
