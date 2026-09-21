# meta-rdke-edgeai

Yocto layer for the EdgeAI platform component (org.rdk.EdgeAI).

Recipes:
- `edgeai-engine`      Thunder plugin + core (Capability Registry, Pipeline Orchestrator, Task-Node Registry, Model Manager, Scheduler)
- `edgeai-task-nodes`  Pluggable task-node plugins (caption-source, defrag, schedule)
- `edgeai-hal-bstorm`  Broadcom/bstorm HAL backend

All recipes fetch from the same `rdke-edgeai` source repo and build a different
CMake target/subdirectory (via `EXTRA_OECMAKE`), so each still produces an
independently deployable package despite the single-repo/single-layer setup.

    bitbake packagegroup-edgeai
