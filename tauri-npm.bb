DESCRIPTION = "Tauri, a toolkit for building smaller, faster, and more secure desktop applications with a web frontend."
HOMEPAGE = "https://github.com/qarmin/yocto-tauri-example"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7deaad7e6b8cbb056cb1eb4a4b274545"

SRC_URI = "git://github.com/qarmin/yocto-tauri-example.git;protocol=https;branch=master"
SRC_URI += "npmsw://${THISDIR}/npm-shrinkwrap.json"
SRCREV = "4b332d9b4ea51fbeb30c095152c77d4d7297fd4f"

S = "${WORKDIR}/git"

DEPENDS = "nodejs-native gtk+3 webkitgtk"

inherit npm

do_compile() {
    npm --prefix ${S} install ${S}
}

do_install() {
    install -d ${D}${prefix}/lib/node_modules/tauri-npm
    cp -R ${S}/node_modules/* ${D}${prefix}/lib/node_modules/tauri-npm
}

FILES_${PN} += "${prefix}/lib/node_modules/tauri-npm/*"

