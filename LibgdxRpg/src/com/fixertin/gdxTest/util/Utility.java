package com.fixertin.gdxTest.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;

public final class Utility {
    public static final AssetManager assetManager = new AssetManager();

    private static final String TAG = Utility.class.getSimpleName();
    private static InternalFileHandleResolver filePathResolver = new InternalFileHandleResolver();

    public static void unloadAsset(String assetFilenamePath){
        // once the asset manager is done loading
        if(assetManager.isLoaded(assetFilenamePath) ){
            assetManager.unload(assetFilenamePath);
        } else {
            Gdx.app.debug(TAG, "Asset is not loaded; Nothing to unload: "+ assetFilenamePath );
        }
    }
    public static float loadCompleted(){
        return assetManager.getProgress();
    }
    public static int numberAssetsQueued(){
        return assetManager.getQueuedAssets();
    }
    public static boolean updateAssetLoading(){
        return assetManager.update();
    }
    public static boolean isAssetLoaded(String fileName){
        return assetManager.isLoaded(fileName);
    }
}
