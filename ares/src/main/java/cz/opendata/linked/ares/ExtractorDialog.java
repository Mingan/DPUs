package cz.opendata.linked.ares;

import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;

import cz.cuni.xrg.intlib.commons.configuration.ConfigException;
import cz.cuni.xrg.intlib.commons.module.dialog.BaseConfigDialog;

/**
 * DPU's configuration dialog. User can use this dialog to configure DPU configuration.
 *
 */
public class ExtractorDialog extends BaseConfigDialog<ExtractorConfig> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7003725620084616056L;
	private GridLayout mainLayout;
    private TextField numDownloads;
    private TextField hoursToCheck;
    private TextField interval;
    private TextField timeout;
    
	public ExtractorDialog() {
		super(new ExtractorConfig());
        buildMainLayout();
        setCompositionRoot(mainLayout);        
    }  
	
    private GridLayout buildMainLayout() {
        // common part: create layout
        mainLayout = new GridLayout(1, 2);
        mainLayout.setImmediate(false);
        mainLayout.setWidth("100%");
        mainLayout.setHeight("100%");
        mainLayout.setMargin(false);
        //mainLayout.setSpacing(true);

        // top-level component properties
        setWidth("100%");
        setHeight("100%");

        numDownloads = new TextField();
        numDownloads.setCaption("Number of downloads in the last X hours:");
        mainLayout.addComponent(numDownloads);
        
        hoursToCheck = new TextField();
        hoursToCheck.setCaption("Count files in cache downloaded in the last X hours:");
        mainLayout.addComponent(hoursToCheck);

        interval = new TextField();
        interval.setCaption("Interval between downloads:");
        mainLayout.addComponent(interval);
        
        timeout = new TextField();
        timeout.setCaption("Timeout for download:");
        
        mainLayout.addComponent(timeout);
        
        return mainLayout;
    }	
     
	@Override
	public void setConfiguration(ExtractorConfig conf) throws ConfigException {
		interval.setValue(Integer.toString(conf.interval));
		timeout.setValue(Integer.toString(conf.timeout));
		numDownloads.setValue(Integer.toString(conf.PerDay));
		hoursToCheck.setValue(Integer.toString(conf.hoursToCheck));
	
	}

	@Override
	public ExtractorConfig getConfiguration() throws ConfigException {
		ExtractorConfig conf = new ExtractorConfig();
		try { Integer.parseInt(numDownloads.getValue()); } catch (InvalidValueException e) { return conf;}
		conf.PerDay = Integer.parseInt(numDownloads.getValue());
		try { Integer.parseInt(hoursToCheck.getValue()); } catch (InvalidValueException e) { return conf;}
		conf.hoursToCheck = Integer.parseInt(hoursToCheck.getValue());
		try { Integer.parseInt(interval.getValue()); } catch (InvalidValueException e) { return conf;}
		conf.interval = Integer.parseInt(interval.getValue());
		try { Integer.parseInt(timeout.getValue()); } catch (InvalidValueException e) { return conf;}
		conf.timeout = Integer.parseInt(timeout.getValue());
		return conf;
	}
	
}