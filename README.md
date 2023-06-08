# PrimeUtil Android Library
PrimeUtil is an efficient Android library designed to simplify the handling of scoped storage. With PrimeUtil, developers can effortlessly save images without the complexities associated with scoped storage implementation. Additionally, the library offers convenient methods to retrieve and manage a list of URIs for images, streamlining the process of accessing and manipulating image resources within the app. Whether you're a beginner or an experienced developer, PrimeUtil provides a hassle-free solution for managing scoped storage in your Android projects.

## Features (without taking care of scoped storage)
1. Save/Get images 
2. Save Get Videos (still in development process)
3. Save Get Other document files (still in development process)

## Implementation
```
    implementation 'io.github.farimarwat:primeutil:1.1'
```

## Save Image (with permission):
This function save image in  public directory and prompts for permission if required. You have not to care about scoped storage.

Create an instance of ImageSaver() object:
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
mImageSaver.saveImage(
       bitmap = bitmap,
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

## Save Image (without permission):
This is an extension function which works without permission and save image to apps external file dir.
#### Basic Call
```
context.saveImage(bitmap)
```

#### Calling with optional params
Below are all other optional params:
```
 mContext.saveImage(
         bitmap=bitmap,
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
1. imagetype: There are two constants available in the library IMAGE_TYPE_JPEG or IMAGE_TYPE_PNG
2. onSuccess: This callback back provides objects: The uri and path after saving the image
3. onError: Provides any exception if occures

## List Image Uris:
To List all available image's uris from gallery:
Create an instace of ImagePicker():
```
val mImageSaver = ImageSaver(this)
```
### Now call it:
```
mImagePicker.listImagesUris(
       self = true,
       onObtained = {uri ->

       },
       onCompleted = { list ->

       },
       onError = {

       }
   )
```
1. self = If it is true then it will list only self created image from gallery (default is false. Only Work with android 10+)
2. onObrained = It is triggered when it founds a uri
3. onCompleted = It is called when all uris are collected
4. onError: This callback trigggers when any exception occurs

## Other Helpful Extension functions:
### Get File Path From Uri
``` 
CoroutineScope(Dispatchers.IO).launch {
      val path = context.getFilePathFromUri(uri)
  }
```
### Get File Path From Uri (Alternate)
```
context.getForceFilePathFromUri(
      uri = uri,
      onSuccess = { path ->

      },
      onError = {ex ->

      }
  )
```
**Note: Getting file path with force method uses cache. First it copies the file to cache dir then get it path**

### Getting uri info
```
context.getUriInfo(
         uri =uri,
         onSucces = { uriInfo ->
         
         },
         onError = {ex ->

         }
     )
```


  
