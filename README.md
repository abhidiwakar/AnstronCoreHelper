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
        corehelper.getFileSizeFromURI() # use any method now.
        ...
}
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.



## License
[MIT](https://choosealicense.com/licenses/mit/)
