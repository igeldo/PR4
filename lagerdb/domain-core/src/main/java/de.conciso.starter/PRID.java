package de.conciso.starter;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PRID implements Serializable{
    @Column(name = "produkt_id")
    private int produktId;

    @Column(name = "rohstoff_id")
    private int rohstoffId;
}