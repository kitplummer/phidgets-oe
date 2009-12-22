LICENSE = "GPL"
DESCRIPTION = "phidgets library"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Kit Plummer <kitplummer at dozersoftware.com>"
PR = "r1"

SRC_URI += "http://www.phidgets.com/downloads/libraries/Phidgetlinux_2.1.5.20090105.tar.gz \
        file://phidgets_make.patch;patch=1"

S = "${WORKDIR}/Phidgetlinux/"

do_configure () {
  echo "No configuration needed for Phidgets library"
}

do_compile () {
  cd ${S}phidget21
  make
}

do_install () {
  install -d ${D}${libdir}/
  install -m 755 ${S}phidget21/libphidget21.so ${D}${libdir}/
}

FILES_${PN} = "${libdir}/libphidget21.so
