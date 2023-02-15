package ca.skynetcloud.cobblemonplaceholder.impl.party;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class OTUuidParser extends PartyParser {

    public OTUuidParser() {
        super(0);
    }

    protected OTUuidParser(final int slot) {
        super(slot);
    }
    @Override
    public String getID() {
        return "party_ot_" + this.slot + "_uuid";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new OTUuidParser(i));
        }
    }

    @Override
    public Object parse(Player p0, Pokemon p1, String[] p2) {
        return p1.getOwnerUUID();
    }
}
