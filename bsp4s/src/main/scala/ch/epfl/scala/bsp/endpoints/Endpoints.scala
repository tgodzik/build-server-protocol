package ch.epfl.scala.bsp
package endpoints

import scala.meta.jsonrpc.Endpoint

object Build extends Build
trait Build {
  object initialize
      extends Endpoint[InitializeBuildParams, InitializeBuildResult]("build/initialize")
  object initialized extends Endpoint[InitializedBuildParams, Unit]("build/initialized")
  object exit extends Endpoint[Exit, Unit]("build/exit")
  object shutdown extends Endpoint[Shutdown, Unit]("build/shutdown")
  object showMessage extends Endpoint[ShowMessageParams, Unit]("build/showMessage")
  object logMessage extends Endpoint[LogMessageParams, Unit]("build/logMessage")
  object publishDiagnostics
      extends Endpoint[PublishDiagnosticsParams, Unit]("build/publishDiagnostics")
  object taskStart extends Endpoint[TaskStartParams, Unit]("build/taskStart")
  object taskProgress extends Endpoint[TaskProgressParams, Unit]("build/taskProgress")
  object taskFinish extends Endpoint[TaskFinishParams, Unit]("build/taskFinish")
}

object BuildTarget extends BuildTarget
trait BuildTarget {
  object compile extends Endpoint[CompileParams, CompileResult]("buildTarget/compile")
  object test extends Endpoint[TestParams, TestResult]("buildTarget/test")
  object run extends Endpoint[RunParams, RunResult]("buildTarget/run")
  object cleanCache extends Endpoint[CleanCacheParams, CleanCacheResult]("buildTarget/cleanCache")

  object didChange extends Endpoint[DidChangeBuildTarget, Unit]("buildTarget/didChange")

  object sources extends Endpoint[SourcesParams, SourcesResult]("buildTarget/sources")
  object inverseSources
      extends Endpoint[InverseSourcesParams, InverseSourcesResult]("buildTarget/inverseSources")
  object dependencySources
      extends Endpoint[DependencySourcesParams, DependencySourcesResult](
        "buildTarget/dependencySources")
  object resources extends Endpoint[ResourcesParams, ResourcesResult]("buildTarget/resources")

  // Scala specific endpoints
  object scalacOptions
      extends Endpoint[ScalacOptionsParams, ScalacOptionsResult]("buildTarget/scalacOptions")
  object scalaTestClasses
      extends Endpoint[ScalaTestClassesParams, ScalaTestClassesResult](
        "buildTarget/scalaTestClasses")
  object scalaMainClasses
      extends Endpoint[ScalaMainClassesParams, ScalaMainClassesResult](
        "buildTarget/scalaMainClasses")
  object executionEnvironment extends Endpoint[ExecutionEnvironmentParams, ExecutionEnvironmentResult]("buildTarget/executionEnvironment")

}

object Workspace extends Workspace
trait Workspace {
  object buildTargets
      extends Endpoint[WorkspaceBuildTargetsRequest, WorkspaceBuildTargetsResult](
        "workspace/buildTargets")
}

object DebugSession extends DebugSession

trait DebugSession {
  object start extends Endpoint[DebugSessionParams, DebugSessionAddress]("debugSession/start")
}
