package ca.skynetcloud.cobblemonplaceholder.impl.global;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.api.Parser;
import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.storage.NoPokemonStoreException;
import org.bukkit.entity.Player;

public class CobblemonVersionParser implements Parser {
    @Override
    public String getID() {
        return "version";
    }

    @Override
    public void register() {
        CobblemonExpansion.registerParser(new CobblemonVersionParser());
    }

    @Override
    public Object parse(Player p0, String[] p1) throws NoPokemonStoreException {
        return Cobblemon.VERSION;
    }
}
