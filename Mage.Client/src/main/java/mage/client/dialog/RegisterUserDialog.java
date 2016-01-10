package mage.client.dialog;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.swing.SwingWorker;
import mage.client.MageFrame;
import mage.client.util.Config;
import mage.remote.Connection;
import mage.remote.Session;
import mage.remote.SessionImpl;
import org.apache.log4j.Logger;

public class RegisterUserDialog extends MageDialog {

    private static final Logger logger = Logger.getLogger(ConnectDialog.class);
    private Connection connection;
    private ConnectTask task;
    private Session session;

    /**
     * Creates new form RegisterUserDialog
     */
    public RegisterUserDialog() {
        initComponents();
    }

    public void showDialog() {
        this.txtServer.setText(MageFrame.getPreferences().get("serverAddress", Config.serverName));
        this.txtPort.setText(MageFrame.getPreferences().get("serverPort", Integer.toString(Config.port)));
        this.lblStatus.setText("");

        this.setModal(true);
        this.setLocation(50, 50);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblServer = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        txtServer = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblPasswordConfirmation = new javax.swing.JLabel();
        txtPasswordConfirmation = new javax.swing.JPasswordField();
        lblEmail = new javax.swing.JLabel();
        lblPasswordConfirmationReasoning = new javax.swing.JLabel();
        lblEmailReasoning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register");

        lblServer.setLabelFor(txtServer);
        lblServer.setText("Server:");

        lblPort.setLabelFor(txtPort);
        lblPort.setText("Port:");

        lblUserName.setLabelFor(txtUserName);
        lblUserName.setText("User name:");

        lblPassword.setLabelFor(txtPassword);
        lblPassword.setText("Password:");

        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });

        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblStatus.setToolTipText("");

        lblPasswordConfirmation.setLabelFor(txtPasswordConfirmation);
        lblPasswordConfirmation.setText("Password:");

        lblEmail.setLabelFor(txtEmail);
        lblEmail.setText("Email:");

        lblPasswordConfirmationReasoning.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        lblPasswordConfirmationReasoning.setLabelFor(txtPasswordConfirmation);
        lblPasswordConfirmationReasoning.setText("(confirmation)");

        lblEmailReasoning.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        lblEmailReasoning.setLabelFor(txtEmail);
        lblEmailReasoning.setText("(used for password reset)");
        lblEmailReasoning.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblPasswordConfirmationReasoning)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblServer)
                                .addComponent(lblUserName)
                                .addComponent(lblPort)
                                .addComponent(lblPassword)
                                .addComponent(lblPasswordConfirmation)
                                .addComponent(lblEmail))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPasswordConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(lblEmailReasoning)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnRegister)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancel)))
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServer)
                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPort)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPasswordConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPasswordConfirmation))
                .addComponent(lblPasswordConfirmationReasoning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmailReasoning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnRegister))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.hideDialog();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        if (!this.txtPassword.getText().equals(this.txtPasswordConfirmation.getText())) {
            MageFrame.getInstance().showError("Passwords don't match.");
            return;
        }
        connection = new Connection();
        connection.setHost(this.txtServer.getText().trim());
        connection.setPort(Integer.valueOf(this.txtPort.getText().trim()));
        connection.setUsername(this.txtUserName.getText().trim());
        connection.setPassword(this.txtPassword.getText().trim());
        connection.setEmail(this.txtEmail.getText().trim());
        PreferencesDialog.setProxyInformation(connection);
        task = new ConnectTask();
        task.execute();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private class ConnectTask extends SwingWorker<Boolean, Void> {

        private boolean result = false;

        private static final int CONNECTION_TIMEOUT_MS = 2100;

        @Override
        protected Boolean doInBackground() throws Exception {
            lblStatus.setText("Connecting...");
            btnRegister.setEnabled(false);
            session = new SessionImpl(MageFrame.getInstance());
            result = session.register(connection);
            return result;
        }

        @Override
        protected void done() {
            try {
                get(CONNECTION_TIMEOUT_MS, TimeUnit.MILLISECONDS);
                if (result) {
                    lblStatus.setText("Registration succeeded");
                    MageFrame.getInstance().showMessage("Registration succeeded");
                    hideDialog();
                } else {
                    lblStatus.setText("Could not register");
                }
            } catch (InterruptedException ex) {
                logger.fatal("Update Players Task error", ex);
            } catch (ExecutionException ex) {
                logger.fatal("Update Players Task error", ex);
            } catch (CancellationException ex) {
                logger.info("Registration was canceled");
                lblStatus.setText("Registration was canceled (but an account might have been actually created)");
            } catch (TimeoutException ex) {
                logger.fatal("Registration timeout: ", ex);
            } finally {
                MageFrame.stopConnecting();
                btnRegister.setEnabled(true);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailReasoning;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordConfirmation;
    private javax.swing.JLabel lblPasswordConfirmationReasoning;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblServer;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordConfirmation;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtServer;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
