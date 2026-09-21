SUMMARY = "EdgeAI pluggable task-node libraries (caption-source, defrag, schedule)"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/<org>/rdke-edgeai.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "-DEDGEAI_BUILD_ENGINE=OFF -DEDGEAI_BUILD_SCHEMA=OFF -DEDGEAI_BUILD_THUNDER_PLUGIN=OFF -DEDGEAI_BUILD_TASK_NODES=ON -DEDGEAI_BUILD_HAL_BSTORM=OFF -DEDGEAI_BUILD_TESTS=OFF"

FILES:${PN} += "${libdir}/libedgeai_node_*.so"
