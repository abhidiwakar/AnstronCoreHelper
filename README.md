# AnstronCoreHelper

AnstronCoreHelper contains some common methods used often in android.

## Installation

Step 1. Add the JitPack repository to your build file.
 
-Add it in your project level build.gradle at the end of repositories:

```bash
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Step 2. Add the dependency.

-Add it in your app level build.gradle file.
```
dependencies {
      ...
      implementation 'com.github.abhidiwakar:AnstronCoreHelper:1.1'
}
```

## Usage

```python
import com.anstrontechnologies.corehelper.AnstronCoreHelper;

AnstronCoreHelper coreHelper;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ...
        coreHelper = new AnstronCoreHelper(this); # Initialize in onCreate method.
        corehelper.getFileSizeFromURI(); # use any method now.
        ...
}
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## Available Methods

```
1. getRandomNumber();  # get random number in the given range.
2. createAlert();  # create and show an alert box with custom message.
3. createToast();  # show basic toast message.
4. getFileNameFromUri();  # return file name of the given uri.
5. getReadableFileSize();  # return file size in human readable format (Ex. 2048 to 2 MB).
6. getTimeStamp();  # return timestamp;
7. getDateTime();  # return current date and time in "yyyy-MM-dd hh:mm a" format or a custom specified format.
8. firstUpperCase();  # return string after changing it's first letter in uppercase.
9. getFileSizeFromUri();  # return file size of the given uri.
10. timestampToDateTime();  # convert given timestamp to date and time in "yyyy-MM-dd HH:mm a" format.
```


## License
[MIT](https://choosealicense.com/licenses/mit/)
