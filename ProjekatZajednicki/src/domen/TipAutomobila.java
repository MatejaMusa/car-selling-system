package domen;

public enum TipAutomobila {
  MIKROAUTOMOBILI("Mikroautomobili"),
  HATCHBACK("Hatchback"),
  LIMUZINA("Limuzina"),
  KARAVAN("Karavan"),
  SUPERMINI("Supermini");

  private String tipAutomobila;

    private TipAutomobila(String tipAutomobila) {
        this.tipAutomobila = tipAutomobila;
    }

  

  @Override
  public String toString() {
    return tipAutomobila;
  }

  public static TipAutomobila getName(String value) {
    for (TipAutomobila name : TipAutomobila.values()) {
      if (name.toString().equals(value)) {
        return name;
      }
    }

    return null;
  }
    
}
