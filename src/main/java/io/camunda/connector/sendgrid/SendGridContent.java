package io.camunda.connector.sendgrid;

import com.google.gson.annotations.Since;
import java.util.Objects;

public class SendGridContent {
  @Since(0.1)
  private String subject;

  @Since(0.1)
  private String type;

  @Since(0.1)
  private String value;

  public void replaceSecrets(final SecretStore secretStore) {
    subject = secretStore.replaceSecret(subject);
    type = secretStore.replaceSecret(type);
    value = secretStore.replaceSecret(value);
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(final String subject) {
    this.subject = subject;
  }

  public String getType() {
    return type;
  }

  public void setType(final String type) {
    this.type = type;
  }

  public String getValue() {
    return value;
  }

  public void setValue(final String value) {
    this.value = value;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final SendGridContent that = (SendGridContent) o;
    return Objects.equals(subject, that.subject)
        && Objects.equals(type, that.type)
        && Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subject, type, value);
  }

  @Override
  public String toString() {
    return "SendGridContent{"
        + "subject='"
        + subject
        + '\''
        + ", type='"
        + type
        + '\''
        + ", value='"
        + value
        + '\''
        + '}';
  }
}