## 导入方式
#### 将JitPack存储库添加到您的构建文件中(项目根目录下build.gradle文件)
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
#### 添加依赖项
```
dependencies {
	        implementation 'com.github.keluokeda:id_card2:1.0.3'
	}
```

## 使用方法
#### 1.添加abiFilters；
```
ndk {
            // 设置支持的SO库架构
            abiFilters 'armeabi' //, 'x86', 'armeabi-v7a', 'x86_64', 'arm64-v8a'
        }
```
#### 2.替换开发码
```
Devcode.devcode="QMVPAMLUZYBXAW5";
```
#### 3.在strings.xml中配置app名称和公司名称
```
 <string name="app_name">慧号通开发包</string>
 <string name="company_name">Beijing Eparking Technology Co.</string>
```
