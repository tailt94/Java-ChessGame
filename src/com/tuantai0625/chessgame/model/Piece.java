package com.tuantai0625.chessgame.model;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

import java.io.Serializable;

/**
 * Created by Lionheart on 12-Jun-17.
 */
public abstract class Piece {
    public static final String BLACK = "black";
    public static final String WHITE = "white";

    protected ImageView image;
    protected String color;
    protected OnDragCompleteListener mListener;

    public Piece(String color) {
        this.color = color;
        String filePath = "com/tuantai0625/chessgame/assets/pieces/" + this.getColor() + "_" + this.getName() + ".png";
        this.image = new ImageView(filePath);
        this.image.setFitWidth(62.5);
        this.image.setFitHeight(62.5);

        this.image.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = image.startDragAndDrop(TransferMode.MOVE);
                db.setDragView(image.getImage());
                ClipboardContent content = new ClipboardContent();
                content.putString(getColor() + "_" + getName());
                db.setContent(content);

                event.consume();
            }
        });

        this.image.setOnDragDone(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if (event.getTransferMode() == TransferMode.MOVE) {
                    mListener.onDragComplete();
                }
                event.consume();
            }
        });
    }

    public ImageView getImage() {
        return this.image;
    }

    public String getColor() {
        return this.color;
    }

    public void setOnDragCompleteListener(OnDragCompleteListener listener) {
        this.mListener = listener;
    }

    public abstract String getName();

    public interface OnDragCompleteListener {
        void onDragComplete();

    }
}
