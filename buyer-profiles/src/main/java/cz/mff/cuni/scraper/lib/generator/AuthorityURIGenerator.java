package cz.mff.cuni.scraper.lib.generator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jakub Starka
 */
public class AuthorityURIGenerator extends TemplateURIGenerator {

    public AuthorityURIGenerator() {
        super(null);
    }

    @Override
    protected URL generateUrl() {
        try {
            return new URL("http://purl.org/procurement/public-contracts-authority-kinds#" + UUID.randomUUID());
        } catch (MalformedURLException ex) {
            Logger.getLogger(URIGenerator.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
