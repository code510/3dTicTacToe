package com.example.glttt;

public class GamePresenter {

    private IGameView mGameView;

    public GamePresenter( IGameView gameView ) {
        mGameView = gameView;
    }

    /*public boolean onTouchEvent( MotionEvent e, ScaleGestureDetector gestureDetector ) {
        //Log.e("game", "onTouchEvent(): pointer count: " + e.getPointerCount());
        String action;
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                break;

            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                break;

            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";
                break;

            case MotionEvent.ACTION_POINTER_UP:
                action = "ACTION_POINTER_UP";
                break;

            case MotionEvent.ACTION_POINTER_2_DOWN:
                action = "ACTION_POINTER_2_DOWN";
                break;

            case MotionEvent.ACTION_POINTER_2_UP:
                action = "ACTION_POINTER_2_UP";
                break;

            default:
                action = "unknown (" + e.getAction() + ")";
        }
        Log.e("game", "onTouchEvent(): " + action);
        float x = e.getRawX() - mGameView.getContentViewLeft();
        float y = e.getRawY() - mGameView.getContentViewLeft();

        ModelObject mo = mGameView.getClickedModelObject((int)x, (int)y);
        Log.e("game", "clicked object: " + mo);

        return true;
    }*/

    public SceneFactory.TYPE getCurrentSceneType() {
        return SceneFactory.TYPE.GAME_BOARD_SCENE;
    }
}
