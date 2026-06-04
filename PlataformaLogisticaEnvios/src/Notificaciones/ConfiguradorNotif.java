package Notificaciones;

/*Principio LSP*/

public class ConfiguradorNotif implements FabricaNotificaciones{
    private final CanalEnvio canalElegido;
    private final FormatoMensaje formatoElegido;

    public ConfiguradorNotif(CanalEnvio canalElegido, FormatoMensaje formatoElegido) {
        this.canalElegido = canalElegido;
        this.formatoElegido = formatoElegido;
    }

    @Override
    public CanalEnvio crearCanal() {
        return this.canalElegido;
    }

    @Override
    public FormatoMensaje crearFormato() {
        return this.formatoElegido;
    }
}
