package padroesprojeto.adapter.hospital;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonitorPacienteTest {

    @Test
    void deveConverterFahrenheitParaCelsius() {
        SensorTemperatura sensor = new AdaptadorFahrenheit(new TermometroFahrenheit(98.6f));
        assertEquals(37.0f, sensor.getTemperaturaCelsius(), 0.01f);
    }

    @Test
    void deveConverterKelvinParaCelsius() {
        SensorTemperatura sensor = new AdaptadorKelvin(new TermometroKelvin(310.15f));
        assertEquals(37.0f, sensor.getTemperaturaCelsius(), 0.01f);
    }

    @Test
    void deveClassificarNormalComTermometroFahrenheit() {
        MonitorPaciente monitor = new MonitorPaciente(new AdaptadorFahrenheit(new TermometroFahrenheit(98.6f)));
        assertEquals("Normal", monitor.classificar());
    }

    @Test
    void deveClassificarFebreComTermometroFahrenheit() {
        MonitorPaciente monitor = new MonitorPaciente(new AdaptadorFahrenheit(new TermometroFahrenheit(101.3f)));
        assertEquals("Febre", monitor.classificar());
    }

    @Test
    void deveClassificarHipotermiaComTermometroFahrenheit() {
        MonitorPaciente monitor = new MonitorPaciente(new AdaptadorFahrenheit(new TermometroFahrenheit(94.0f)));
        assertEquals("Hipotermia", monitor.classificar());
    }

    @Test
    void deveClassificarComTermometroKelvin() {
        assertEquals("Normal", new MonitorPaciente(new AdaptadorKelvin(new TermometroKelvin(310.15f))).classificar());
        assertEquals("Febre", new MonitorPaciente(new AdaptadorKelvin(new TermometroKelvin(312.15f))).classificar());
    }

    @Test
    void deveAdaptarPorHeranca() {
        AdaptadorFahrenheitPorHeranca adaptador = new AdaptadorFahrenheitPorHeranca(104.0f);

        assertTrue(adaptador instanceof SensorTemperatura);
        assertTrue(adaptador instanceof TermometroFahrenheit);
        assertEquals(40.0f, adaptador.getTemperaturaCelsius(), 0.01f);
        assertEquals("Febre", new MonitorPaciente(adaptador).classificar());
    }

    @Test
    void clienteDeveFuncionarComSensorNativoSemAdaptador() {
        assertEquals("Normal", new MonitorPaciente(new TermometroDigital(36.5f)).classificar());
        assertEquals("Febre", new MonitorPaciente(new TermometroDigital(37.8f)).classificar());
    }

    @Test
    void adaptadorDeveRefletirAlteracaoNaLeituraDoAdaptado() {
        TermometroFahrenheit termometro = new TermometroFahrenheit(98.6f);
        MonitorPaciente monitor = new MonitorPaciente(new AdaptadorFahrenheit(termometro));
        assertEquals("Normal", monitor.classificar());

        termometro.setLeitura(103.0f);

        assertEquals("Febre", monitor.classificar());
    }

    @Test
    void todosOsSensoresDevemSerUsadosPelaMesmaInterface() {
        SensorTemperatura[] sensores = {
                new TermometroDigital(37.0f),
                new AdaptadorFahrenheit(new TermometroFahrenheit(98.6f)),
                new AdaptadorKelvin(new TermometroKelvin(310.15f)),
                new AdaptadorFahrenheitPorHeranca(98.6f)
        };

        for (SensorTemperatura sensor : sensores) {
            assertEquals(37.0f, sensor.getTemperaturaCelsius(), 0.05f);
        }
    }
}
