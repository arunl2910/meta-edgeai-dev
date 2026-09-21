SUMMARY = "EdgeAI Thunder plugin + core (org.rdk.EdgeAI)"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/<org>/rdke-edgeai.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

# Real sibling found: entservices-displayinfo.bb at
# mw/rdke/middleware/generic/meta-rdk-video/recipes-extended/entservices/ (missed earlier --
# that's a populated layer tree under mw/rdke, distinct from the mostly-empty App/rdke
# checkout searched first). It DEPENDS on "wpeframework wpeframework-tools-native" (the
# latter provides the JSON-RPC/interface codegen tools) and lives under
# recipes-extended/<component>/, not recipes-wpe/ -- matched here.
DEPENDS = "wpeframework wpeframework-tools-native"

inherit cmake

EXTRA_OECMAKE = "-DEDGEAI_BUILD_ENGINE=ON -DEDGEAI_BUILD_SCHEMA=OFF -DEDGEAI_BUILD_THUNDER_PLUGIN=ON -DEDGEAI_BUILD_TASK_NODES=OFF -DEDGEAI_BUILD_HAL_BSTORM=OFF -DEDGEAI_BUILD_TESTS=OFF"

FILES:${PN} += "${libdir}/wpeframework/plugins/libEdgeAI.so \
                ${sysconfdir}/wpeframework/plugins/EdgeAI.json"
