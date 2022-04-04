package de.conciso.starter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link PersonRepresentation}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePersonRepresentation.builder()}.
 */
@Generated(from = "PersonRepresentation", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutablePersonRepresentation implements PersonRepresentation {
  private final String vorname;
  private final String name;

  private ImmutablePersonRepresentation(String vorname, String name) {
    this.vorname = vorname;
    this.name = name;
  }

  /**
   * @return The value of the {@code vorname} attribute
   */
  @Override
  public String getVorname() {
    return vorname;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PersonRepresentation#getVorname() vorname} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for vorname
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePersonRepresentation withVorname(String value) {
    String newValue = Objects.requireNonNull(value, "vorname");
    if (this.vorname.equals(newValue)) return this;
    return new ImmutablePersonRepresentation(newValue, this.name);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PersonRepresentation#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePersonRepresentation withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutablePersonRepresentation(this.vorname, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePersonRepresentation} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePersonRepresentation
        && equalTo(0, (ImmutablePersonRepresentation) another);
  }

  private boolean equalTo(int synthetic, ImmutablePersonRepresentation another) {
    return vorname.equals(another.vorname)
        && name.equals(another.name);
  }

  /**
   * Computes a hash code from attributes: {@code vorname}, {@code name}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + vorname.hashCode();
    h += (h << 5) + name.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code PersonRepresentation} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "PersonRepresentation{"
        + "vorname=" + vorname
        + ", name=" + name
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link PersonRepresentation} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable PersonRepresentation instance
   */
  public static ImmutablePersonRepresentation copyOf(PersonRepresentation instance) {
    if (instance instanceof ImmutablePersonRepresentation) {
      return (ImmutablePersonRepresentation) instance;
    }
    return ImmutablePersonRepresentation.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePersonRepresentation ImmutablePersonRepresentation}.
   * <pre>
   * ImmutablePersonRepresentation.builder()
   *    .vorname(String) // required {@link PersonRepresentation#getVorname() vorname}
   *    .name(String) // required {@link PersonRepresentation#getName() name}
   *    .build();
   * </pre>
   * @return A new ImmutablePersonRepresentation builder
   */
  public static ImmutablePersonRepresentation.Builder builder() {
    return new ImmutablePersonRepresentation.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePersonRepresentation ImmutablePersonRepresentation}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PersonRepresentation", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_VORNAME = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private long initBits = 0x3L;

    private String vorname;
    private String name;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code PersonRepresentation} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(PersonRepresentation instance) {
      Objects.requireNonNull(instance, "instance");
      vorname(instance.getVorname());
      name(instance.getName());
      return this;
    }

    /**
     * Initializes the value for the {@link PersonRepresentation#getVorname() vorname} attribute.
     * @param vorname The value for vorname 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder vorname(String vorname) {
      this.vorname = Objects.requireNonNull(vorname, "vorname");
      initBits &= ~INIT_BIT_VORNAME;
      return this;
    }

    /**
     * Initializes the value for the {@link PersonRepresentation#getName() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePersonRepresentation ImmutablePersonRepresentation}.
     * @return An immutable instance of PersonRepresentation
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePersonRepresentation build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePersonRepresentation(vorname, name);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_VORNAME) != 0) attributes.add("vorname");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      return "Cannot build PersonRepresentation, some of required attributes are not set " + attributes;
    }
  }
}
