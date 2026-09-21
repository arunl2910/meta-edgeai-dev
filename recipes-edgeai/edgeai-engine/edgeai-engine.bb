SUMMARY = "EdgeAI Thunder plugin + core (org.rdk.EdgeAI)"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/<org>/rdke-edgeai.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

# wpeframework: Thunder plugin host. No local org.rdk.* sibling plugin recipe exists in
# this checkout to copy from (traced packagegroup-application-layer.bb -- no org.rdk.*
# Thunder plugin is actually built anywhere in this stack), so this recipe follows the
# standard upstream Thunder plugin shape (SERVICE_REGISTRATION/IPlugin/JSONRPC) instead.
DEPENDS = "wpeframework"

inherit cmake

EXTRA_OECMAKE = "-DEDGEAI_BUILD_ENGINE=ON -DEDGEAI_BUILD_SCHEMA=OFF -DEDGEAI_BUILD_THUNDER_PLUGIN=ON -DEDGEAI_BUILD_TASK_NODES=OFF -DEDGEAI_BUILD_HAL_BSTORM=OFF -DEDGEAI_BUILD_TESTS=OFF"

FILES:${PN} += "${libdir}/wpeframework/plugins/libEdgeAI.so \
                ${sysconfdir}/wpeframework/plugins/EdgeAI.json"
