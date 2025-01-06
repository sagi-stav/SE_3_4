package acptTests;

import bridgeProject.BridgeProject;
import bridgeProject.BridgeProxy;
import bridgeProject.RealBridge;

public abstract class Driver {
	public static BridgeProject getBridge() {
		BridgeProxy bridge = new BridgeProxy();
		bridge.setRealBridge(new RealBridge()); // הוספנו את RealBridge
		return bridge;
	}
}