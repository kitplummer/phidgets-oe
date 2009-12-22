LICENSE = "GPL"
DESCRIPTION = "phidgets library"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Kit Plummer <kitplummer at dozersoftware.com>"

SRC_URI = "http://www.phidgets.com/downloads/libraries/Phidgetlinux_2.1.5.20090105.tar.gz \
        file://phidgets_make.patch;patch=1;pnum=1"

inherit autotools

S = "${WORKDIR}"


do_patch () {
 cd ${S}/Phidgetlinux/
 patch -p1 < ${S}/patches/phidgets_make.patch
}

do_configure () {
  echo "No configuration needed for Phidgets library"
}

do_compile () {
  cd ${S}/Phidgetlinux/phidget21
  make
}

do_install () {
  install -d ${D}${libdir}/
  install -m 755 ${S}/Phidgetlinux/phidget21/libphidget21.so ${D}${libdir}/

#  cd ${S}/Phidgetlinux/phidget21
#  cp libphidget21.so ${D}/libphidget21.so
}

FILES_${PN} = "${libdir}/libphidget21.so
