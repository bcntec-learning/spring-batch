package houseware.learn.spring.batch.case08;

/**
 * @author fphilip@houseware.es
 */
public class ImportMetadataHolder {

    private ImportMetadata importMetadata;

    public ImportMetadata get() {
        return importMetadata;
    }

    public void set(ImportMetadata importMetadata) {
        this.importMetadata = importMetadata;
    }

}
