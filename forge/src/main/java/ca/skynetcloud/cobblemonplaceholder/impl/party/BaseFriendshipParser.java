package ca.skynetcloud.cobblemonplaceholder.impl.party;

import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.impl.PartyParser;
import com.cobblemon.mod.common.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class BaseFriendshipParser extends PartyParser {

    public BaseFriendshipParser(){
        super (0);

    }
    protected BaseFriendshipParser(int slot) {
        super(slot);
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_base_friendship";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new BaseFriendshipParser(i));
        }
    }

    @Override
    public Object parse(Player player, Pokemon pokemon, String[] args) {
        return pokemon.getSpecies().getBaseFriendship();
    }
}
