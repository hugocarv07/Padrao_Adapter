package padroesprojeto.adapter.hospital;

public class MonitorPaciente {

    private final SensorTemperatura sensor;

    public MonitorPaciente(SensorTemperatura sensor) {
        this.sensor = sensor;
    }

    public String classificar() {
        float temperatura = sensor.getTemperaturaCelsius();
        if (temperatura < 35.0f) {
            return "Hipotermia";
        }
        if (temperatura >= 37.8f) {
            return "Febre";
        }
        return "Normal";
    }
}
