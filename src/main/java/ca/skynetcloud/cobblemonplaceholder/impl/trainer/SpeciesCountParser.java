

package ca.skynetcloud.cobblemonplaceholder.impl.trainer;


import ca.skynetcloud.cobblemonplaceholder.CobblemonExpansion;
import ca.skynetcloud.cobblemonplaceholder.api.Parser;
import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.api.storage.NoPokemonStoreException;
import org.bukkit.entity.Player;

public class SpeciesCountParser implements Parser
{
    @Override
    public String getID() {
        return "species_count";
    }
    
    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            CobblemonExpansion.registerParser(new SpeciesCountParser());
        }
    }

    @Override
    public Object parse(Player p0, String[] p1) throws NoPokemonStoreException {
        return PokemonSpecies.INSTANCE.count();
    }

}
