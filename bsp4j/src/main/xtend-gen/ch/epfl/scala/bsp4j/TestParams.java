package ch.epfl.scala.bsp4j;

import ch.epfl.scala.bsp4j.BuildTargetIdentifier;
import java.util.List;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SuppressWarnings("all")
public class TestParams {
  @NonNull
  private List<BuildTargetIdentifier> targets;
  
  private String originId;
  
  @NonNull
  private List<String> arguments;
  
  public TestParams(@NonNull final List<BuildTargetIdentifier> targets, @NonNull final List<String> arguments) {
    this.targets = targets;
    this.arguments = arguments;
  }
  
  @Pure
  @NonNull
  public List<BuildTargetIdentifier> getTargets() {
    return this.targets;
  }
  
  public void setTargets(@NonNull final List<BuildTargetIdentifier> targets) {
    this.targets = targets;
  }
  
  @Pure
  public String getOriginId() {
    return this.originId;
  }
  
  public void setOriginId(final String originId) {
    this.originId = originId;
  }
  
  @Pure
  @NonNull
  public List<String> getArguments() {
    return this.arguments;
  }
  
  public void setArguments(@NonNull final List<String> arguments) {
    this.arguments = arguments;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("targets", this.targets);
    b.add("originId", this.originId);
    b.add("arguments", this.arguments);
    return b.toString();
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TestParams other = (TestParams) obj;
    if (this.targets == null) {
      if (other.targets != null)
        return false;
    } else if (!this.targets.equals(other.targets))
      return false;
    if (this.originId == null) {
      if (other.originId != null)
        return false;
    } else if (!this.originId.equals(other.originId))
      return false;
    if (this.arguments == null) {
      if (other.arguments != null)
        return false;
    } else if (!this.arguments.equals(other.arguments))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.targets== null) ? 0 : this.targets.hashCode());
    result = prime * result + ((this.originId== null) ? 0 : this.originId.hashCode());
    return prime * result + ((this.arguments== null) ? 0 : this.arguments.hashCode());
  }
}
