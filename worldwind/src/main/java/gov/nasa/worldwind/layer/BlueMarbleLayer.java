/*
 * Copyright (c) 2016 United States Government as represented by the Administrator of the
 * National Aeronautics and Space Administration. All Rights Reserved.
 */

package gov.nasa.worldwind.layer;

import gov.nasa.worldwind.geom.Sector;
import gov.nasa.worldwind.ogc.WmsLayer;
import gov.nasa.worldwind.ogc.WmsLayerConfig;
import gov.nasa.worldwind.util.Logger;

/**
 * Displays NASA's Blue Marble next generation imagery at 240 pixels/degree resolution from an OGC Web Map Service
 * (WMS). By default, BlueMarbleLayer is configured to retrieve Blue Marble imagery for May 2004 from the WMS at <a
 * href="http://worldwind25.arc.nasa.gov/wms?SERVICE=WMS&REQUEST=GetCapabilities">http://worldwind25.arc.nasa.gov/wms</a>.
 * <p/>
 * Information on NASA's Blue Marble next generation imagery can be found at http://earthobservatory.nasa.gov/Features/BlueMarble/
 */
public class BlueMarbleLayer extends WmsLayer {

    /**
     * Constructs a Blue Marble image layer with the WMS at http://worldwind25.arc.nasa.gov/wms.
     */
    public BlueMarbleLayer() {
        this("http://worldwind25.arc.nasa.gov/wms");
    }

    /**
     * Constructs a Blue Marble image layer with the WMS at a specified address.
     *
     * @param serviceAddress a URL string specifying the WMS address
     *
     * @throws IllegalArgumentException If the service address is null
     */
    public BlueMarbleLayer(String serviceAddress) {
        if (serviceAddress == null) {
            throw new IllegalArgumentException(
                Logger.logMessage(Logger.ERROR, "BlueMarbleLayer", "constructor", "missingServiceAddress"));
        }

        WmsLayerConfig config = new WmsLayerConfig();
        config.serviceAddress = serviceAddress;
        config.wmsVersion = "1.3.0";
        config.layerNames = "BlueMarble-200405";
        config.coordinateSystem = "EPSG:4326";
        this.setConfiguration(new Sector().setFullSphere(), 240, config);
    }
}