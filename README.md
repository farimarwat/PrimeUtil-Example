# PrimeUtil Android Library
PrimeUtil is an efficient Android library designed to simplify the handling of scoped storage. With PrimeUtil, developers can effortlessly save images without the complexities associated with scoped storage implementation. Additionally, the library offers convenient methods to retrieve and manage a list of URIs for images, streamlining the process of accessing and manipulating image resources within the app. Whether you're a beginner or an experienced developer, PrimeUtil provides a hassle-free solution for managing scoped storage in your Android projects.

## Save Image:
Create an instance of ImageSave() object:
```
 val mImageSaver = ImageSaver(this) // provide context as param
```
#### Basic Call
Now Call with basic params:
```
mImageSaver.saveImage(bitmap)
```
This will save image to "Pictures" dir in both cases android 10+ and below. You does not need to add any permissions etc.
#### Calling with optional params
Below are all other optional params:
```
mImageSaver.saveImage(bitmap,
                     folder = "MyFolder",
                     imagetype = IMAGE_TYPE_JPEG,
                     onSuccess = { uri, path ->
                         Log.e(TAG, "Uri: $uri")
                         Log.e(TAG,"Path: $path")
                     },
                     onError = {
                         Log.e(TAG, "Error: $it")
                     }
                 )
```
1. folder: To create a seperate folder inside "Pictures" and save all your images there
2. imagetype: There are two constants available in the library IMAGE_TYPE_JPEG or IMAGE_TYPE_PNG
3. onSuccess: This callback back provides objects: The uri and path after saving the image
4. onError: Provides any exception if occures
