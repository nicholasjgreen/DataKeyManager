package DataKeyManagerIntegration.Provider;

public interface DataKeyGeneratorProvider {
    DataKeyManagerIntegration.DTO.GenerateDataKeyResult generateDataKey(String keyId);
}
