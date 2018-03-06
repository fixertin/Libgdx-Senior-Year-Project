package com.fixertin.gdxTest.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;

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
    public static void loadTextureAsset(String textureFilenamePath){
        if( textureFilenamePath == null || textureFilenamePath.isEmpty()){
            return;
        }
        //load asset
        if( filePathResolver.resolve(textureFilenamePath).exists() ){
            assetManager.setLoader(Texture.class, new TextureLoader(filePathResolver));
            assetManager.load(textureFilenamePath, Texture.class);
            //Until we add loading screen,
            //just block until we load the map
            assetManager.finishLoadingAsset(textureFilenamePath);
        }
        else{
            Gdx.app.debug(TAG, "Texture doesn’t exist!: " +
                    textureFilenamePath );
        }
    }
    public static Texture getTextureAsset(String textureFilenamePath){
        Texture texture = null;
        // once the asset manager is done loading
        if(assetManager.isLoaded(textureFilenamePath) ){
            texture =
                    assetManager.get(textureFilenamePath,Texture.class);
        } else {
            Gdx.app.debug(TAG, "Texture is not loaded: " +
                    textureFilenamePath );
        }
        return texture;
    }

}
