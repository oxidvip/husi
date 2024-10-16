## 🛠️ Contribution

## 🧭 Guide

[CONTRIBUTING](./CONTRIBUTING.md)

### 🔨 Learn to Compilation

In Linux, you can build husi reproducibly for relase version.

For this, you should use the same version of JDK, NDK as below. And Go version should as same as [version.sh](./buildScript/init/version.sh).

#### 🧰 Get the Source Code

```shell
git clone https://github.com/oxidvip/husi.git --depth=1
cd husi/
./run lib source # Will help you to get submodules
```

#### ⚖️ libcore

Environment:

* Go But should apply patch

  Go1.22.5: Apply [this patch](./libcore/patches/cgo_go1225.diff) to `${GOROOT}/src/runtime/cgocall.go`

  Go1.23: Apply [this patch](https://go-review.googlesource.com/changes/go~600296/revisions/1/patch) (You should decode base64 first) to `${GOROOT}`

* Openjdk-17 (Later is OK, too.)

Run:

```shell
make libcore
```

This will generate `app/libs/libcore.aar`.

If gomobile is not in the GOPATH, it will be automatically downloaded and compiled.

If you don't want to build it, you can download then in [actions](https://github.com/oxidvip/husi/actions)

#### 🎁 APK

Environment:

* jdk-17-openjdk
* ndk 27.0.12077973

If the environment variables `$ANDROID_HOME` and `$ANDROID_NDK_HOME` are not set, you can run the script `buildScript/init/env_ndk.sh`:

```shell
echo "sdk.dir=${ANDROID_HOME}" > local.properties
```

Signing preparation (optional, it is recommended to sign after compilation): Replace `release.keystore` with your own keystore.

```shell
echo "KEYSTORE_PASS=" >> local.properties
echo "ALIAS_NAME=" >> local.properties
echo "ALIAS_PASS=" >> local.properties
```

Download geo resource files:

```shell
make assets
```

Compile the release version:

```shell
make apk
```

The APK file will be located in `app/build/outputs/apk`.

#### 🌈 Plugins

```shell
make plugin PLUGIN=<Plugin name>
```

Plugin name list:

* `hysteria2`

## 📖 License

[GPL-3.0](./LICENSE)

## 🛡️ Credits

Core:

- [SagerNet/sing-box](https://github.com/SagerNet/sing-box)
