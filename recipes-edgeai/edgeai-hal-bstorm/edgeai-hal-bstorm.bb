SUMMARY = "EdgeAI HAL backend for Broadcom/bstorm"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/<org>/rdke-edgeai.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

DEPENDS = "bstorm-core"

inherit cmake

EXTRA_OECMAKE = "-DEDGEAI_BUILD_ENGINE=OFF -DEDGEAI_BUILD_SCHEMA=OFF -DEDGEAI_BUILD_THUNDER_PLUGIN=OFF -DEDGEAI_BUILD_TASK_NODES=OFF -DEDGEAI_BUILD_HAL_BSTORM=ON"

FILES:${PN} += "${libdir}/libedgeai_hal_bstorm.so"
