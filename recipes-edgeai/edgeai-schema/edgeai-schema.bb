SUMMARY = "EdgeAI capability/pipeline/manifest schema + loader (AI-37-02)"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/<org>/rdke-edgeai.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

DEPENDS = "nlohmann-json"

inherit cmake

EXTRA_OECMAKE = "-DEDGEAI_BUILD_ENGINE=OFF -DEDGEAI_BUILD_SCHEMA=ON -DEDGEAI_BUILD_THUNDER_PLUGIN=OFF -DEDGEAI_BUILD_TASK_NODES=OFF -DEDGEAI_BUILD_HAL_BSTORM=OFF -DEDGEAI_BUILD_TESTS=OFF"

FILES:${PN} += "${libdir}/libedgeai_schema_loader.a"
FILES:${PN}-dev += "${datadir}/edgeai/schema/*.json"

do_install:append() {
    install -d ${D}${datadir}/edgeai/schema
    install -m 0644 ${S}/schema/*.schema.json ${D}${datadir}/edgeai/schema/
    install -d ${D}${datadir}/edgeai/schema/samples
    install -m 0644 ${S}/schema/samples/*.json ${D}${datadir}/edgeai/schema/samples/
}
