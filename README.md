# meta-rdke-edgeai

Yocto layer for the EdgeAI platform component (org.rdk.EdgeAI).

Recipes:
- `edgeai-engine`      Thunder plugin + core (Capability Registry, Pipeline Orchestrator, Task-Node Registry, Model Manager, Scheduler)
- `edgeai-task-nodes`  Pluggable task-node plugins (caption-source, defrag, schedule)
- `edgeai-hal-bstorm`  Broadcom/bstorm HAL backend

All recipes fetch from the same `rdke-edgeai` source repo and build a different
CMake target/subdirectory (via `EXTRA_OECMAKE`), so each still produces an
independently deployable package despite the single-repo/single-layer setup.

A real sibling Thunder plugin recipe exists in this stack: `entservices-displayinfo.bb`
at `mw/rdke/middleware/generic/meta-rdk-video/recipes-extended/entservices/` (not
found on the first pass, which only searched the mostly-empty `App/rdke` checkout).
`edgeai-engine.bb`'s `DEPENDS` and the `EdgeAI`/`EdgeAIImplementation` out-of-process
split (`IShell::Root<IEdgeAI>()`, `configuration.root.mode`) are modeled on it.

    bitbake packagegroup-edgeai
