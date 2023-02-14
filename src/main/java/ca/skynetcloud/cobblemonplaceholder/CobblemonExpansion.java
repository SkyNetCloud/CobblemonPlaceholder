package ca.skynetcloud.cobblemonplaceholder;

import ca.skynetcloud.cobblemonplaceholder.api.Parser;
import ca.skynetcloud.cobblemonplaceholder.impl.party.*;

import com.google.common.collect.Sets;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Set;

public class CobblemonExpansion extends PlaceholderExpansion {
    private static final Set<Parser> defaultParsers;
    private static final HashMap<String, Parser> parsers;

    public static void registerParser(final Parser parser) {
        CobblemonExpansion.parsers.put(parser.getID(), parser);
    }

    public boolean canRegister() {
        return true;
    }

    public String getIdentifier() {
        return "cobblemon";
    }

    public String getAuthor() {
        return "SkyNetCloud";
    }

    public String getVersion() {
        return "1.0.0";
    }

    public boolean register() {
        CobblemonExpansion.defaultParsers.forEach(Parser::register);
        return super.register();
    }

    public String onRequest(final OfflinePlayer player, final String identifier) {
        if (player != null && player.isOnline()) {
            return this.onPlaceholderRequest(player.getPlayer(), identifier);
        }
        return null;
    }

    public String onPlaceholderRequest(final Player p, final String identifier) {
        if (p == null || !p.isOnline()) {
            return "INVALID_PLAYER";
        }
        final String formattedInput = identifier.replace("\\s+", "_").toLowerCase();
        final Player player = p.getPlayer();
        final Parser parser = CobblemonExpansion.parsers.get(formattedInput);
        if (parser != null) {
            final String[] args = formattedInput.split("_");
            return parser.parse(player, args).toString();
        }
        return "Could not parse request check syntax please";
    }

    static {
        defaultParsers = Sets.newHashSet(
                new EvIvParser(),
                new GenderParser(),
                new NatureParser(),
                new PokeballParser(),
                new LevelParser()
        );
        parsers = new HashMap<>();
    }
}
